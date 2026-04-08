def call(String credId, String imageName, String tagname){
Docker_Login(credId)
                sh '''
                docker build ${env.dockerHubUser}/${imageName} .
                '''
                }  
}
