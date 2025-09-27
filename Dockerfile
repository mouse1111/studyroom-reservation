FROM ubuntu:latest
LABEL authors="pjh"

ENTRYPOINT ["top", "-b"]