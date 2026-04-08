def call(String credId){
  withCredentials([usernamePassword(
                    credentialsId:"${credId}",
                    passwordVariable: "dockerHubPass",
                    usernameVariable: "dockerHubUser"
                )]){
        sh '''
echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin
'''
  }
}
