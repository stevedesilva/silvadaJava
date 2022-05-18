#!/usr/bin/env bash
echo "building..."
docker build -t lazy-scheduler .
echo "running..."
docker run -it --rm -v $(pwd):/build -w /build --name test-lazy-scheduler lazy-scheduler
