pipeline {
    agent { docker 'gradle:4.5-jdk8-alpine' }
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
