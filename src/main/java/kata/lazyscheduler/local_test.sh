#!/usr/bin/env bash
docker build -t lazy-scheduler .
docker run -it --rm --name test-lazy-scheduler lazy-scheduler
