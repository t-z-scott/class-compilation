sed -i 's/\r//g' main.c
gcc main.c -o Signal
./Signal
sed -i 's/\r//g' script.sh
chmod +x script.sh
./script.sh