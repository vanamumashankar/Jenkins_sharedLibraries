def call(String credId, String imageName, String tagname) {

    def user = Docker_Login(credId)

    sh """
    docker tag ${user}/${imageName} ${user}/${imageName}:${tagname}
    docker push ${user}/${imageName}:${tagname}
    """
}
