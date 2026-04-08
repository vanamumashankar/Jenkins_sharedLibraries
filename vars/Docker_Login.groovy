def call(String credId){
  withCredentials([usernamePassword(
                    credentialsId:"${credId}",
                    passwordVariable: "dockerHubPass",
                    usernameVariable: "dockerHubUser"
                )]){
        sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
  }
}
