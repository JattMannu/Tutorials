import csv

data_1 = 'primary_schools_with_latlong.csv'

SCHOOLS = []

with open(data_1) as csv_file:
    csv_reader = csv.reader(csv_file, delimiter=',')
    line_count = 0
    for row in csv_reader:
        if line_count == 0:
            # Skipping the headers
            line_count += 1
        else:
            print(row[0])
            cood = [row[0], float(row[1]), float(row[2])]
            SCHOOLS.append(cood)
            line_count += 1
HDBs = []
with open('hdb-property-information-with-latlong-latest-resale-price.csv') as csv_file:
    csv_reader = csv.reader(csv_file, delimiter=',')
    line_count = 0
    for row in csv_reader:
        if line_count == 0:
            # Skipping the headers
            line_count += 1
        else:
            if row[7] != '':
                cood = [float(row[7]),float(row[4]), float(row[5])]
                HDBs.append(cood)
            line_count += 1

import math




# 2km = 0.02
for school in SCHOOLS:
    school_name = school[0]
    school_latitude =school[1]
    school_longitude = school[2]
    resale = 0
        #float("inf")
    for hdb in HDBs:
        hdb_resale = hdb[0]
        hdb_latitude = hdb[1]
        hdb_longitude = hdb[2]
        distance = math.sqrt((school_latitude - hdb_latitude) ** 2 + (school_longitude - hdb_longitude) ** 2 )
        if distance <= 0.02 and resale == 0:
            resale = hdb_resale
        elif distance <= 0.02 and resale != 0:
            resale = (resale + hdb_resale)/2
            #print(resale)
    school.append(resale)


f = open('result.csv', 'w')

with f:
    writer = csv.writer(f)
    writer.writerow(["school_name", "latitude", "longitude","avg_resale"])
    for school in SCHOOLS:
        writer.writerow(school)


print("")