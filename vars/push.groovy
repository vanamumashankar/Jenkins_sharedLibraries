def call(String credId, String imageName, String tagname) {

    def user = Docker_Login(credId)

    sh """
    # Tag image (only if needed)
    docker tag ${user}/${imageName} ${user}/${imageName}:${tagname}

    # Push image
    docker push ${user}/${imageName}:${tagname}

    # Stop and remove old container if exists
    docker rm -f notes || true

    # Run new container
  #  docker run -d --name notes -p 8000:8000 ${user}/${imageName}:${tagname}
    docker run -d --name notes -p 8000:8000 \
-e DB_NAME=notes \
-e DB_USER=root \
-e DB_PASSWORD=password \
-e DB_HOST=mysql \
${user}/${imageName}:${tagname}
    """
}
