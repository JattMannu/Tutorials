#!/bin/bash

# FOO=' test test test '
# FOO='/////log/test/test/'
# FOO_NO_LEAD_SLASH="$(echo -e "${FOO}" | sed -e 's/^[/]*//')"
# echo -e "FOO_NO_LEAD_SPACE='${FOO_NO_LEAD_SLASH}'"



function remove_leading_slash() {
    param1=$1
    result="$(echo -e "${param1}" | sed -e 's/^[/]*//')"
    echo ${result}
}




t=$(remove_leading_slash '/////log/test/test/')
echo -e "t=${t}"


