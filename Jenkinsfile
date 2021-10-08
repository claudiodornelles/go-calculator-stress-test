pipeline {

   agent any

   stages {
      stage('Run Gatling stress test') {
         steps {
            sh './gradlew gatlingRun'
         }
      }
   }
}
