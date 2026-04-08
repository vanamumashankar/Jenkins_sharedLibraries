def call(String credId, String imageName, String tagname) {

    def user = Docker_Login(credId)

    sh """
    docker tag ${user}/${imageName} ${user}/${imageName}:${tagname}
    docker push ${user}/${imageName}:${tagname}
    docker compose down
    docker run -d --name notes -p 8000:8000 ${user}/${imageName}:${tagname}
    """
}
