pipeline {
    
    agent any

    stages {

        stage('Build') {
            steps {
                script{
                sh("mvn clean install -DskipTests")
                }
            }
        }

        stage('Build') {
            steps {
                script{
                sh("mvn test")
                }
            }
        }
     
    }
}