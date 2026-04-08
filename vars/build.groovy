def call(String credId, String imageName){
Docker_Login(credId)
                sh '''
                docker build -t ${env.dockerHubUser}/${imageName} .
                '''
                }  
}
