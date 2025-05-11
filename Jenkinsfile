pipeline {
    agent any

    environment {
        DOCKERHUB_CREDENTIALS = 'docker-hub'
        IMAGE_NAME = 'macclare/java-calculator-app'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    sh "docker build -t $IMAGE_NAME ."
                }
            }
        }

        stage('Push to Docker Hub') {
            steps {
                withCredentials([usernamePassword(credentialsId: "${DOCKERHUB_CREDENTIALS}", usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    sh """
                        echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
                        docker push $IMAGE_NAME
                        docker logout
                    """
                }
            }
        }
    }

    post {
        success {
            echo 'Build and push completed successfully!'
        }
        failure {
            echo 'Build failed.'
        }
    }
}
