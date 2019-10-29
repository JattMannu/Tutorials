#!/bin/bash
max=3
count=$max
macAddress=FE:B3:46:00:00:49

sudo hcitool cc $macAddress 2> /dev/null

while true
do
    sleep 0.3
    sudo hcitool cc $macAddress   2> /dev/null
    bt=$(hcitool rssi $macAddress 2> /dev/null)
    rssi=$(echo $bt | grep -P -o "[0-9]+" | head -1)
    echo $rssi
    if [ "$bt" == "" ] && [ $count -gt 0 ]; then
        #sudo hcitool cc FE:B3:46:00:00:49   2> /dev/null
        #bt=$(hcitool rssi FE:B3:46:00:00:49  2> /dev/null)
        count=$((count - 1))
        echo "Disconnected: Drop count" $count
    elif [ "0$rssi" -gt 1 ] && [ $count -gt 0 ]; then
        count=$((count - 1))
        echo "Weak Signal: Drop count" $count
    elif [ "$bt" == "" ] && [ $count -le 0 ]; then
        loginctl lock-session 
    elif [ "0$rssi" -gt 1 ] && [ $count -le 0 ]; then
        loginctl lock-session  
    elif [ "0$rssi" -le 1 ]  && [ $count -gt 0 ]; then
        echo "Signal is Strong : $bt"
        count=$max
        loginctl unlock-session
    else
        echo "Reconnected : $bt"
        count=$max
        loginctl unlock-session
    fi
    
done