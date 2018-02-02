# Magneto

## API Documentation

`URL:` https://magneto-193701.appspot.com/

`Headers`: 
  + For POST requests (with a body): `Content-Type: application/json`

### Mutants
`POST /mutants`
  - Body: `{ "dna":["ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA","TCACTG"] }`
  
### Stats
`GET /stats`
  - Returns: `{
    "count_mutant_dna": 1000,
    "count_human_dna": 2000,
    "ratio": 0.5
  }`
