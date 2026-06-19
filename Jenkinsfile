pipeline {
    agent any

    tools {
        jdk 'JDK21'
        maven 'MAVEN3'
    }

    stages {
        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}