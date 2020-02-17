#!/usr/bin/env bash

ARGS=`getopt -o a:b:c -n "test" -- "$@"`

echo $@

eval set -- ${ARGS}

echo ${ARGS}

while true
do
    echo $1
    case "$1" in
        -a)
            echo "a is $2"
            shift 2
            ;;
        -b)
            echo "b is $2"
            shift 2
            ;;
        -c)
            echo "c is $2"
            shift 1
            ;;
        --)
            echo "nothing";
            shift
            break;
            ;;
        *)
            echo "error"
            exit 1
            ;;
    esac
done

echo "done"