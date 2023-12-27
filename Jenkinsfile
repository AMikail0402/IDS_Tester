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
                sh("sudo /bash_scripts/./tcp.sh")
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