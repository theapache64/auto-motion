echo "Downloading main JAR..." &&
wget -q "https://github.com/theapache64/auto-motion2/releases/latest/download/auto-motion2.main.jar" -O "auto-motion2.main.jar" --show-progress &&

echo "Moving files to ~/.auto-motion2" &&

mkdir -p ~/.auto-motion2 &&
mv auto-motion2.main.jar ~/.auto-motion2/auto-motion2.main.jar

echo "Installing..." &&
echo "\nalias auto-motion2='java -jar ~/.auto-motion2/auto-motion2.main.jar'" >> ~/.bash_aliases &&

echo "Done"