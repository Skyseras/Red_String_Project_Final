# Use an official Node runtime as a parent image
FROM node:14.17.0-alpine3.13

# Set the working directory to /app
WORKDIR /WeBuy_Frontend

# Copy the package.json and package-lock.json files to the working directory
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the rest of the application code to the working directory
COPY . .

# Build the application
RUN npm run build --prod

# Expose port 80
EXPOSE 80

# Start the application
CMD ["npm", "run", "start"]
