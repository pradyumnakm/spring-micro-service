pipeline {
  agent any
  stages {
    stage('Start') {
      steps {
        echo 'Starting service'
      }
    }
    stage('Build') {
      steps {
        sh '''echo "building service"
mvn clean package -Dmaven.test.skip=true'''
      }
    }
    stage('Test') {
      steps {
        sh '''echo "Testing Service"

mvn test'''
      }
    }
    stage('End') {
      steps {
        echo 'Completed '
      }
    }
  }
}