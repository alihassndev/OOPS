#!/bin/bash

# Create images directory if it doesn't exist
mkdir -p src/resources/images

# Download background images
curl -o src/resources/images/login_bg.jpg "https://images.unsplash.com/photo-1507842217343-583bb7270b66?w=1024&h=768&fit=crop"
curl -o src/resources/images/register_bg.jpg "https://images.unsplash.com/photo-1521587760476-6c12a4b040da?w=1024&h=768&fit=crop"
curl -o src/resources/images/dashboard_bg.jpg "https://images.unsplash.com/photo-1507842217343-583bb7270b66?w=1024&h=768&fit=crop"

# Download icons
curl -o src/resources/images/book_icon.png "https://cdn-icons-png.flaticon.com/512/2232/2232688.png"
curl -o src/resources/images/user_icon.png "https://cdn-icons-png.flaticon.com/512/1077/1077114.png"

# Make the script executable
chmod +x download_images.sh 