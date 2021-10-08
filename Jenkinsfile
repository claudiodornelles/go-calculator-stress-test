pipeline {

   agent any

   stages {
      stage('Run Gatling stress test') {
         steps {
            sh 'JAVA_OPTS="-Dusers=50"'
            sh './gradlew gatlingRun'
         }
      }
   }
}
