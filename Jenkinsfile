pipeline {
  agent any
  stages {
    stage('Init') {
      steps {
        echo 'Starting...'
      }
    }
    stage('Build') {
      steps {
        sh 'mvn clean install'
      }
    }
    stage('Stop') {
      steps {
        echo 'Build complete'
      }
    }
  }
}