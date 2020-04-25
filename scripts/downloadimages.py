import urllib.request
from urllib.error import HTTPError

BASE_URL = "https://b.cdn.metweb.ie/images/web-meteogram-7day/"


def form_identifier(num: int) -> str:
    number_string = '0' + str(num)
    return number_string[-2:]


numberRange = range(1, 53)
for daynight in ['d', 'n']:
    for n in numberRange:
        in_filename = form_identifier(n) + daynight + '.png'
        url = BASE_URL + in_filename
        out_filename = 'met' + in_filename
        print(url)
        try:
            urllib.request.urlretrieve(url, out_filename)
        except HTTPError as e:
            print(e)



print('done')


