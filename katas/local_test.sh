#!/usr/bin/env bash
echo "building..."
docker build -t lazyscheduler -f docker/KataDockerfile .
echo "running..."
#docker run -it --rm -v $(pwd):/build -w /build --name test-lazy-scheduler lazy-scheduler
docker run -it --rm --name lazyscheduler lazyscheduler