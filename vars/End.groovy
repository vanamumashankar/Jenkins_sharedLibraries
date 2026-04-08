def call(){
sh '''
docker compose down
docker compose up -d
echo "bye, The App is running on port:8000"
'''
}
