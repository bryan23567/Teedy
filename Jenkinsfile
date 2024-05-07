pipeline {
    agent any
    stages{
        stage('Package') {
            steps {
                bat 'mvn -B -DskipTests clean package'
            }
        }
        // Building Docker images
        stage('Building image') {
            steps{
                script {
                    docker.build("nopyesok/practicedocker:firstversion")
                }
            }
        }
        // Uploading Docker images into Docker Hub
        stage('Upload image') {
            steps{
                script {
                    docker.withRegistry('https://registry.hub.docker.com', '12112230') {
                        docker.image("nopyesok/practicedocker:firstversion").push()
                    }
                }
            }
        }
        //Running Docker container
        stage('Run containers'){
            steps{
                script{
                    docker.run("nopyesok/practicedocker:firstversion")
                }
            }
        }
    }
}
