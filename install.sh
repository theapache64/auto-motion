echo "Downloading main JAR..." &&
wget -q "https://github.com/theapache64/auto-motion/releases/latest/download/auto-motion.main.jar" -O "auto-motion.main.jar" --show-progress &&

echo "Moving files to ~/.auto-motion" &&

mkdir -p ~/.auto-motion &&
mv auto-motion.main.jar ~/.auto-motion/auto-motion.main.jar

echo "Installing..." &&
echo "\nalias auto-motion='java -jar ~/.auto-motion/auto-motion.main.jar'" >> ~/.bash_aliases &&

echo "Done"