pipeline {
    
    agent any

    stages {

        stage('Truncate Table'){
          steps {
                script{
                sh("curl --request DELETE --url http://localhost:3001/clean")
                }
            }
        }        

        stage('TCP Packets'){
          steps {
                script{
                sh("sudo hping3 127.0.0.1 --rand-source --destport 8228 -c 1")
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