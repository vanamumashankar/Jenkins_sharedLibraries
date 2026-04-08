def call(String credId, String imageName, String tagname){
  withCredentials([usernamePassword(
                    credentialsId:"${credId}",
                    passwordVariable: "dockerHubPass",
                    usernameVariable: "dockerHubUser"
                )]){
                
                sh '''
                docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}
                docker tag ${imageName} ${env.dockerHubUser}/${imageName}
                docker push ${env.dockerHubUser}/${imageName}:${tagname}
                '''
                }  
}
