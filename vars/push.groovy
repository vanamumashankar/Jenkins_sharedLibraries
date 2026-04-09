def call(String credId, String imageName, String tagname) {

    def user = Docker_Login(credId)

    sh """
    # Tag image (only if needed)
    docker tag ${user}/${imageName} ${user}/${imageName}:${tagname}

    # Push image
    docker push ${user}/${imageName}:${tagname}

docker compose down && docker compose up
}
