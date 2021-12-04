pipeline {
    agent { docker 'gradle:6.3-jdk14' }
    stages {
        stage ('Checkout') {
          steps {
            git 'https://github.com/dnojawod/Assignment1.git'
          }
        }
        stage('Build') {
            steps {
                sh 'gradle clean compileJava'
            }
        }   
    }
}
