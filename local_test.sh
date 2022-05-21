#!/usr/bin/env bash
echo "building..."
docker build -t lazy-scheduler -f katas/Dockerfile .
echo "running..."
#docker run -it --rm -v $(pwd):/build -w /build --name test-lazy-scheduler lazy-scheduler
docker run -it --rm --name test-lazy-scheduler lazy-scheduler bash