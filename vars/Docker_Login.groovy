def call(String credId) {
    def username = ""

    withCredentials([usernamePassword(
        credentialsId: credId,
        usernameVariable: 'DOCKER_USER',
        passwordVariable: 'DOCKER_PASS'
    )]) {

        sh '''
        echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin
        '''

        username = env.DOCKER_USER
    }

    return username
}
