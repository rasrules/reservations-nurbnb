FROM openjdk:17

COPY entrypoint.sh /usr/local/bin/entrypoint.sh
RUN chmod +x /usr/local/bin/entrypoint.sh

#Start application
WORKDIR /usr/src/myapp
ENTRYPOINT ["/usr/local/bin/entrypoint.sh"]
CMD ["bash"]
