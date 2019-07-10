#!/usr/bin/env bash
SHOPURL=${SHOPURL-localhost:8080}
AUSER="Mike-$RANDOM"

curl -X POST -H "Content-Type: application/json" http://${SHOPURL}/developer -d "{\"name\": \"$AUSER\"}" && echo
