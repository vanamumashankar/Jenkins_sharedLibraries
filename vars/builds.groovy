def call(String credId, String imageName) {

    def user = Docker_Login(credId)

    sh """
    docker build -t ${user}/${imageName} .
    """
}
