pipeline {
    
    agent any

    stages {

        stage('TCP Packets'){
          steps {
                script{
                sh("mvn clean install -DskipTests")
                }
            }
        }
        
        stage('Build') {
            steps {
                script{
                sh("mvn clean install -DskipTests")
                }
            }
        }

        stage('HTTP and Test') {
            steps {
                script{
                sh("mvn test")
                }
            }
        }
     
    }
}