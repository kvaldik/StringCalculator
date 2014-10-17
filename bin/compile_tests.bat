if not exist classes (
    mkdir classes
)

javac -classpath "classes;lib\junit-4.11.jar" src/test/java/is/kvaldik/stringcalculator/*.java -d classes