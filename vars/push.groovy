def call(String credId, String imageName, String tagname) {

    def user = Docker_Login(credId)

    sh """
    # Tag & Push
    docker tag ${user}/${imageName} ${user}/${imageName}:${tagname}
    docker push ${user}/${imageName}:${tagname}

    # Create network (ignore if exists)
    docker network create my || true

    # Create volume
    docker volume create mysql_data || true

    # Remove old containers if exist
    docker rm -f mysql notes || true

    # Run MySQL container
    docker run -d \
      --name db_cont \
      --network my \
      -e MYSQL_ROOT_PASSWORD=root \
      -e MYSQL_DATABASE=test_db \
      -v mysql_data:/var/lib/mysql \
      mysql:5.7

    # Wait for MySQL to start
    sleep 20

    # Run Django container
    docker run -d \
      --name notes \
      --network my \
      -p 8000:8000 \
      -e DB_NAME=test_db \
      -e DB_USER=root \
      -e DB_PASSWORD=root \
      -e DB_HOST=db_cont \
      ${user}/${imageName}:${tagname}
    """
}
