<#import "../tools/layout.ftl" as layout>

<@layout.basic "Notlarım">
    Notes
    <div id="noteApp">
        <div class="row">
            <div class="col-12 mb-3">
                <label for="exampleFormControlTextarea1" class="form-label">Example textarea</label>
                <textarea class="form-control" id="exampleFormControlTextarea1" v-model="note.payload"
                          rows="3"></textarea>

                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" id="rb-type-text" v-model="note.type" value="TEXT">
                    <label class="form-check-label" for="rb-type-text">TEXT</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" id="rb-type-link" v-model="note.type" value="LINK">
                    <label class="form-check-label" for="rb-type-link">LINK</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" id="rb-type-reminder" v-model="note.type"
                           value="REMINDER">
                    <label class="form-check-label" for="rb-type-reminder">REMINDER</label>
                </div>
                <button type="button" class="btn btn-sm btn-primary" @click="save">Save</button>
                <button type="button" class="btn btn-sm btn-warning" @click="clean">Clean</button>
                <div id="" v-text="note.payload">

                </div>
            </div>
            <div class="col-12">
                <label>Labels</label>
                <input type="text" @blur="addLabel($event.target.value)" v-model="newLabel"/>
                <div>
                    <span class="badge bg-info text-dark" v-for="label in note.labels"
                          @click="removeLabel(label.label)">{{ label.label }}</span>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <ul class="list-group">
                    <li v-for="note in notes" class="list-group-item" :class="typeStyle">
                        <div> {{ note.payload }}</div>
                        <div class="float-end">
                            <span class="badge bg-primary rounded-pill">{{ note.type }}</span>
                        </div>
                        <div>
                            <span class="badge bg-info text-dark" v-for="label in note.labels"> {{ label.label }}</span>
                        </div>
                    </li>

                </ul>

            </div>


        </div>
    </div>
    <script src="https://unpkg.com/vue@next"></script>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

    <script>
        function isURL(text) {
            const urlRegex = /(https?:\/\/[^\s]+)/g;
            return urlRegex.test(text);
        }

        function existsInLabelList(labels, label) {
            console.log(labels.filter(l => l.label === label));
            return labels.filter(l => l.label === label).length > 0;
        }

        const noteApp = {
            data() {
                return {
                    intelligentLabels: ['youtube', 'you', 'medium.com'],
                    newLabel: '',
                    notes: [],
                    note: {
                        id: 0,
                        payload: '',
                        type: 'TEXT',
                        author: {
                            id: 25,
                            firstName: '',
                            lastName: ''
                        },
                        labels: [{label: 'youtube'}]
                    }
                }
            }, methods: {
                changeNoteType(type) {
                    const self = this;
                    self.note.type = type;
                },
                addLabel(newLabel) {
                    this.note.labels.push({label: newLabel});
                    this.newLabel = '';
                },
                removeLabel(existingLabel) {
                    this.note.labels = this.note.labels.filter(l => l.label != existingLabel);
                },
                listNotes() {
                    const self = this;
                    axios.get('/api/v1/notes?authorId=25')
                        .then(function (response) {
                            console.log(response);
                            self.notes = response.data;
                        })
                        .catch(function (error) {
                            console.log(error);
                        });
                },
                save() {
                    const self = this;
                    axios.post('/api/v1/notes', self.note)
                        .then(function (response) {
                            console.log(response);
                            self.listNotes();
                        })
                        .catch(function (error) {
                            console.log(error);
                        });
                },
                clean() {
                    const self = this;
                    self.note.payload = '';
                }
            }, mounted() {
                const self = this;
                self.listNotes();
            }, created() {
                const self = this;
                self.$watch('note.payload', (newValue, oldValue) => {
                    const words = newValue.split(' ').filter(w => w.length > 0).map(w => w.trim());
                    if (words.length == 0) {
                        self.note.labels = [];
                        return;
                    }
                    //Detect deletion and clear all labels and add again. - easyway
                    if (oldValue.length > newValue.length) {
                        self.note.labels = [];
                    }

                    let wordCount = 0;
                    self.note.type = 'TEXT';
                    while (words.length > wordCount) {
                        const word = words[wordCount];
                        self.intelligentLabels
                            .filter(label => (word.length > 0 && word.toLowerCase().indexOf(label) != -1))
                            .forEach(value => {
                                if (!existsInLabelList(self.note.labels, value)) {
                                    self.note.labels.push({label: value})
                                }
                            });

                        if (isURL(word)) {
                            self.note.type = 'LINK';
                            break;
                        }
                        wordCount++;
                    }
                })
            },
            computed: {
                typeStyle() {
                    return '';
                }
            }
        }

        Vue.createApp(noteApp).mount('#noteApp')


    </script>
</@layout.basic>