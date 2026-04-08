def call(String credId, String imageName, String tagname){
def user = Docker_Login(credId)
                sh '''
                docker push ${user}/${imageName}:${tagname}
                '''
                }  
}
