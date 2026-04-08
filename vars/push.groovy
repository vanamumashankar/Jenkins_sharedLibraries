def call(String credId, String imageName, String tagname){
Docker_Login(credId)
                sh '''
                docker push ${env.dockerHubUser}/${imageName}:${tagname}
                '''
                }  
}
