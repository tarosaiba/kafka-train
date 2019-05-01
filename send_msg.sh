#!/bin/bash

if [ ! $# -eq 1 ]; then
    echo "usage: $0 <msg_count>"
    exit 1;
fi

HOST="localhost:1323"
COUNT=$1

for i in `seq -f %02g $1 `; do
   curl -X POST -H 'Content-Type: application/json' -d '{"body":"Massage: '$i'"}' ${HOST}/kafka
done
