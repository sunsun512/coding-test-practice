import re

def solution(new_id):

    new_id = new_id.lower()

    new_id = re.sub('[^a-z-_\.0-9]', '', new_id)

    new_id = re.sub('[\.]+', '.', new_id)

    new_id = re.sub('^\.', '', new_id)  

    new_id = re.sub('\.$', '', new_id) 

    if not new_id:
        new_id = 'a'

    if len(new_id) >= 16:
        new_id = new_id[:15]
        new_id = re.sub('\.$', '', new_id) 

    if len(new_id) < 3:
        while len(new_id)<3:
            new_id += new_id[-1]

    answer = new_id
    return answer
