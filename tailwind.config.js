/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ['./src/main/resources/templates/**/*.html',
  './src/main/resources/templates/**/*.svg'],
  theme: {
    extend: {},
  },
  plugins: [require('@tailwindcss/container-queries'),require('daisyui'),require('@tailwindcss/forms'),require('@tailwindcss/typography')],
}

