<#import "../tools/layout.ftl" as layout>

<@layout.basic "Labels">
    <div id="noteApp">
        <div class="row">
            <div class="col-12 mb-3">

            </div>
            <div class="col-12">
                <div>
                    <span class="badge bg-info text-dark" v-for="label in labels" @click="showLabelNotes(label.label)">{{ label.label }}</span>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <ul class="list-group">
                    <li v-for="note in notes" class="list-group-item">
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
        const noteApp = {
            data() {
                return {
                    labels: [],
                    notes: []
                }
            }, methods: {
                showLabelNotes(label) {
                    const self = this;
                    axios.get('/api/v1/notes?authorId=25&label=' + label)
                        .then(function (response) {
                            console.log(response);
                            self.notes = response.data;
                        })
                        .catch(function (error) {
                            console.log(error);
                        });
                },
                listLabels() {
                    const self = this;

                    axios.get('/api/v1/notes/labels')
                        .then(function (response) {
                            console.log(response);
                            self.labels = response.data;
                        })
                        .catch(function (error) {
                            console.log(error);
                        });
                    s
                }
            }, mounted() {
                const self = this;
                self.listLabels();
            }, created() {
                const self = this;
                // self.$watch('note.payload', (newValue, oldValue) => {
                //
                // })
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