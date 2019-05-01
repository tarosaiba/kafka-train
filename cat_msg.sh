#!/bin/bash

if [ ! $# -eq 2 ]; then
    echo "usage: $0 <broker_host> <topic_name>"
    exit 1;
fi

BROKER=$1
TOPIC=$2

docker run -it --rm \
       confluentinc/cp-kafkacat \
       kafkacat -b ${BROKER}:9092 \
       -t ${TOPIC} \
       -P -C\
       -f 'Key: %k\tValue: %s\tPartition: %p\tOffset: %o\n'
