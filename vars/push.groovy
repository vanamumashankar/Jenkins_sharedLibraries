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
    docker run -d --name notes -p 8000:8000 ${user}/${imageName}:${tagname}
    """
}
