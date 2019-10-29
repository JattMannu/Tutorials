#!/bin/bash

s3Upload() {
    echo FOLDER : $1
    echo PREFIX : $2

while [[ true ]]
do
    files=`find "$1""/test.meta" -type f`
    if [[ $files == "" ]] ; then
        echo "nothing changed"
    else
        prefix=$2
        suffix=$(date +%Y-%m-%d-%T)
        echo changed, $files

        files=$(echo $files | tr "," "\n")

        for file in $files
        do
            echo "> [$file]"
        done
        exit
    fi
    sleep 1
done
}

s3Upload lookout sadas